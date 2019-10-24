// v61_1 : Back-end 와 Front-end 분리하기
package com.eomcs.lms;

// 작업1: 게시물 관리
// => /webapp/html/board/list.html 생성
// => /webapp/html/board/form.html 생성
//
//>-v node 노드 버전 확인
//Scoop update nodejs  노드 업데이트

// 작업:2 : npm(node package manager) 으로 외부 CSS, JS 라이브러리 파일 관리하기
// => 콘솔에서 /webapp 폴더로 이동
//  C:\Users\bit\git\bitcamp-java-20190527\bitcamp-java-application4-server\src\main\webapp>
// => 'npm init' 실행 // package name: (webapp) bitcamp 이름만 설정하고 나머지 엔터
//    - package.json 파일 생성
//    - 자바스크립트 라이브러리에 대한 설정 파일
// => 'npm install bootstrap' 실헹
//      - npm을 통해 외부 라이브러리를 다운로드 받는다.
//      - mpm을 실헹한 폴더에 node_modules 디렉토리를 자동 생성하고
//        이 디렉토리에 라이브러리를 자동으로 다운로드 한다.
//      - package.json에 라이브러리 정보가 등록된다.
//        만약 등록되지 않았다면 다음과 같이 --save 옵션을 붙여 실행하라.
//        'npm install bootstrap --save'
//        또는
//        'npm install --save bootstrap'
//       - package.json 파일에 등록된 라이브러리를 모두 자동으로 다운로드 하고 싶다면,
//         다음과 같이 패키지 이름을 지정하지 않고 실행하라.
//         'npm install'
//
// => /webapp/html/board-2/list.html 변경
//   - css, javascript 파일 경로를 npm 폴더 경로로 변경한다.


//npm install sweetalert
//https://sweetalert.js.org/docs/


// 작업3: HTML과 자바스크립트 코드 분리하기
// /webapp/html/board-3/list.js 생성
//  - list.html에서 javascript 코드를 분리한다.
// /webapp/html/board-2/list.html 변경
// - list.js를 가져온다.
// form.html 에서 javascript 코드를 분리해 form.js를 만든다.

// 작업4: 미니 jQuery 만들기
// => /webapp/html/js/bitcamp.js 생성
//   - DOM API와 AJAX를 보다 쉽게 다루는 함수를 만든다.
// => /webapp/html/board-4/list.html, form.html 변경
// 

// 작업5: 미니 jQuery 자바스크립트 파일 압축하기
// => /webapp/html/js/bitcamp.min.js 생성
//   - 자바스크립트 코드의 크리를 줄이기 위해 압축한다.
// => /webbapp/html/../list.html, form.html 변경
//    - bitcamp.min.js 를 사용하도록 변경한다.


// 작업6: 진짜 jQuery 사용하기


// dummy 클래스!
// => 기존 버전에서 계속 존재했던 클래스라서 그대로 둠.
// => 단지 버전의 목표에 대한 설명을 기록하기 위해 존재함.
// => 프로젝트에서 사용되지 않음!
//
public class App {
}










