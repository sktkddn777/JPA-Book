## 엔티티 매니저 설정 (maven)

책에서는 maven 을 기준으로 설명을 진행
JPA는 `META-INF/persistence.xml`을 사용해서 필요한 설정 정보를 관리

```xml
<persistence-unit name="jpabook">
```

```java
// 앤티티 매니저 팩토리 생성
EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");

// 앤티티 매니저 생성
EntityManager em = emf.createEntityManager();

// 트랜잭션 획득
EntityTransaction tx = em.getTransaction();

// 트랜잭션 시작
tx.begin();

// 트랜잭션 커밋
tx.commit();

// 앤티티 매니저 종료
em.close();

// 앤티티 매니저 팩토리 종료
emf.close();
```

`Persistence` 클래스가 `META-INF/persistence.xml` 설정 정보를 조회하여 앤티티 매니저 팩토리를 생성
앤티티 매니저 팩토리는 비용이 아주 크기 때문에, 애플리케이션 전체에서 딱 한 번만 생성하고 공유해서 사용해야 함
앤티티 매니저 팩토리에서 앤티티 매니저를 생성함
앤티티 매니저를 통해 앤티티를 데이터베이스에 CRUD 할 수 있음

<br>

## 방언

- 각 DB마다 제공하는 SQL 문법과 함수가 조금씩 다르다 (DB만의 고유한 기능을 JPA에서는 방언이라 함)
- JPA 구현체들은 (하이버네이트) DB 방언 클래스를 제공함

<br>

## JPQL

- JPA를 사용하면 개발자는 객체를 중심으로 개발하므로, 검색도 객체를 대상으로 검색을 하게 되는데
- 객체를 대상으로 검색하려면, DB의 모든 데이터를 애플리케이션으로 불러와서 앤티티 객체로 변경한 다음 검색해야 한다. (불가능)
- 필요한 데이터만 불러오려면 결국 검색 조건이 포함된 SQL을 사용해야 하는데, JPQL이라는 쿼리 언어가 이를 해결해준다.

JPQL은 앤티티 객체를 대상으로 쿼리함

- select m from Member m

SQL은 테이블을 대상으로 쿼리함

- select M.ID, M.NAME, M.AGE from MEMBER M

- 자세한건 10장에서..

<br>

## 앤티티 매니저 설정 (스프링부트)

- 스프링 프레임워크 내 JPA를 사용할 때는 트랜잭션을 관리하는 일을 프레임워크가 처리함, 애플리케이션 초기화 시점에 EntityManager를 Bean으로 등록하고

```java
@PersistenceUnit
private EntityManagerFactory factory;


@PersistenceContext
private EntityManager em;
```

- PersistenceContext 어노테이션을 통해 EntityManager를 빈으로 등록할 수 있음
  이때 EntityManagerFactory에서 생성된 em을 생성하거나 기존의 em을 반환해준다

- EntityManager는 여러 스레드가 동시에 접속하면 동시성 문제가 발생하여 공유해서는 안됨
  PersistenceContext로 엔티티 매니저를 주입받아도 괜찮은 이유는

- 스프링 컨테이너가 초기화 되면서 EntityManager를 Proxy로 감싸는데
  그리고 Proxy를 통해 EntityManager를 생성하여 thread-safe를 보장함 (이 부분은 아직 이해가 잘 안된다.. 왜 Proxy로 감싸면 스레드 safe를 보장하지??)
