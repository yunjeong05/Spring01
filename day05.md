# 1. 트랜잭션 처리
1. 트랜잭션(Transaction)이란
- 트랜잭션은 DB에서 일어나는 작업의 단위
- DDL(insert, delete, update)을 실행 할 때 항상 commit 이나 rollback이 실행 되어야 트랜잭션이 완료됨.
- 스프링에서는 AOP기능을 이용해서 트랜잭션 처리를 설정할 수 있다. 

2. 스프링에서의 트랜잭션 
- 트랜잭션을 설정할 때는 애즈펙트 대신에 어드바이저를 사용한다.  //객체의 이름, 함수명을 모를 때 어드바이저를 사용한다.
- 개발자가 쿼리가 실패인지 성공인지를 결정할 수 없기 때문에 commit이나 rollback이 발생하는 순간을 알지 못함. 
  따라서 어드바이저에게 commit, rollback 처리를 맡긴다. 어드바이저는 쿼리가 성공하면 commit을 실패하면 rollback을 자동으로 호출한다. 
- <b>예제 프로젝트: _019_SpringFramework_Transaction</b>

