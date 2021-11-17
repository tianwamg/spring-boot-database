### Spring data JPA + queryDSL

1. JPA
   1. 依赖
```java 
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

```

    2. 配置yaml
```java
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/test?useSSL=false
    username: root
    password: qwer1234
    driver-class-name: com.mysql.cj.jdbc.Driver

  jpa:
    database: mysql
    database-platform: org.hibernate.dialect.MySQL5InnoDBDialect #数据库的方言配置。
    show-sql: true
    hibernate:
      ddl-auto: update
```
- spring.jpa.hibernate.ddl-auto:
   - update该配置比较常用，当服务首次启动会在数据库中生成相应表，后续启动服务时如果实体类有增加属性会在数据中添加相应字段，原来数据仍在。
   - create ：该值慎用，每次重启项目的时候都会删除表结构，重新生成，原来数据会丢失不见。
   - create-drop ：慎用，当项目关闭，数据库中的表会被删掉。
   - validate ： 验证数据库和实体类的属性是否匹配，不匹配将会报错。
   - none: 禁用DDL处理。
   3. 实现
       1. DAO层
		  - xxxRepository extends JpaRepository<T, ID>
	   2. DDL语句
          - 提供简单的crud操作，复杂语句需要自己编写，eg:
```java
	@Query("select u from User u where u.username like %?1%")
	Page<User> findByUsernameLike(String username, Pageable pageable);

	@Transactional()
	@Modifying
	@Query("update User u set u.password = ?2 where u.username = ?1")
	int updatePasswordByUsername(String username, String password);
```
    4. 缺陷
       1. 虽然JPA提供基本操作接口，但是复杂条件需要自己编写；
       2. 提供多表操作，但是操作复杂，例如join操作仍旧需要编写sql;
    5. 改进
       - 实现动态sql,引入queryDSL
2. queryDSL

    1. 依赖

```java
	<dependency>
		<groupId>com.querydsl</groupId>
		<artifactId>querydsl-jpa</artifactId>
	</dependency>
	<dependency>
		<groupId>com.querydsl</groupId>
		<artifactId>querydsl-apt</artifactId>
	</dependency>
```
   
    2. maven插件

```java
	<plugin>
		<groupId>com.mysema.maven</groupId>
		<artifactId>apt-maven-plugin</artifactId>
		<version>1.1.3</version>
		<executions>
			<execution>
				<goals>
					<goal>process</goal>
				</goals>
				<configuration>
					<outputDirectory>target/generated-sources/java</outputDirectory>
					<processor>com.querydsl.apt.jpa.JPAAnnotationProcessor</processor>
				</configuration>
			</execution>
		</executions>
	</plugin>
```
    -  插件用途：该插件会自动扫描项目内配置了@Entity的实体类，并根据实体的内定义的字段以及关联类通过JPAAnnotationProcessor自动创建Q[实体类名称]的查询实体，创建完成后会将实体存放到我们配置outputDirectory属性目录下。

    3. 实现
        1. DAO层
		    - xxxRepository extends JpaRepository<T, ID>, QuerydslPr	edicateExecutor<T>
        2. DDL语句 
```java
	@Autowired
	EntityManager entityManager;

	private JPAQueryFactory queryFactory;

	@PostConstruct
	public void inint(){
		queryFactory = new JPAQueryFactory(entityManager);
	}
	public void queryFactoryTest(){
		QSysUser qSysUser = QSysUser.sysUser;
		SysUser sysUser = queryFactory.selectFrom(qSysUser)
				.where(qSysUser.id.eq(1))
				.fetchOne();
		System.out.println(sysUser.getUserName());

	}
```
- 参考
   - [Spring Data JPA](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference)
   - [QueryDSL博客](https://www.jianshu.com/p/99a5ec5c3bd5)





