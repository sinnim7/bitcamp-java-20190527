package com.eomcs.lms.controller;

import java.util.Collection;
import java.util.UUID;
import javax.annotation.Resource;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;

@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
@Component("/photoboard/update")
public class PhotoBoardUpdateController implements PageController {
  private static final long serialVersionUID = 1L;
  
  @Resource
  String uploadDir;
  private PlatformTransactionManager txManager;
  private PhotoBoardDao photoBoardDao;
  private PhotoFileDao photoFileDao;
  
  

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) 
      throws Exception {
    
    DefaultTransactionDefinition def = new DefaultTransactionDefinition();
    def.setName("tx1");
    def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
    
    TransactionStatus status = txManager.getTransaction(def);
    
      PhotoBoard photoBoard = new PhotoBoard();
      photoBoard.setNo(Integer.parseInt(request.getParameter("no")));
      photoBoard.setTitle(request.getParameter("title"));

      photoBoardDao.update(photoBoard);
      photoFileDao.deleteAll(photoBoard.getNo());

      int count = 0;
      Collection<Part> parts = request.getParts();
      for (Part part : parts) {
        if (!part.getName().equals("filePath") || part.getSize() == 0) {
          continue;
        }
        // 클라이언트가 보낸 파일을 디스크에 저장한다.
        String filename = UUID.randomUUID().toString();
        part.write(uploadDir + "/" + filename);
        
        // 저장한 파일명을 DB에 입력한다.
        PhotoFile photoFile = new PhotoFile();
        photoFile.setFilePath(filename);
        photoFile.setBoardNo(photoBoard.getNo());
        photoFileDao.insert(photoFile);
        count++;
      }
      
      if (count == 0) {
        throw new Exception("사진 파일 없음!");
      }
      
      txManager.commit(status);
      
      return "redirect:list";
      
  }

}
