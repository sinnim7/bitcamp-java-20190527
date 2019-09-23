package com.eomcs.lms.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;

@Component("/photoboard/delete")
public class PhotoBoardDeleteController implements PageController {
  private static final long serialVersionUID = 1L;
  
  @Resource
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
    
      int no = Integer.parseInt(request.getParameter("no"));
      
      if (photoBoardDao.findBy(no) == null) {
        throw new Exception("해당 데이터가 없습니다.");
      }
      
      photoFileDao.deleteAll(no);
      photoBoardDao.delete(no);
      
      txManager.commit(status);
      
      return "redirect:list";
      
  }
}
