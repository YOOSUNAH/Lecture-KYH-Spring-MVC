### SpringMVC 구조
동작 순서
1. 핸들러 조회: 핸들러 매핑을 통해 요청 URL에 매핑된 핸들러(컨트롤러)를 조회한다.
2. 핸들러 어댑터 조회: 핸들러를 실행할 수 있는 핸들러 어댑터를 조회한다.
3. 핸들러 어댑터 실행: 핸들러 어댑터를 실행한다.
4. 핸들러 실행: 핸들러 어댑터가 실제 핸들러를 실행한다.
5. ModelAndView 반환: 핸들러 어댑터는 핸들러가 반환하는 정보를 ModelAndView로 변환해서
   반환한다.
6. viewResolver 호출: 뷰 리졸버를 찾고 실행한다.
   JSP의 경우: InternalResourceViewResolver 가 자동 등록되고, 사용된다.
7. View반환:뷰리졸버는뷰의논리이름을물리이름으로바꾸고,렌더링역할을담당하는뷰객체를
   반환한다.
   JSP의 경우 InternalResourceView(JstlView) 를 반환하는데, 내부에 forward() 로직이 있다.
8. 뷰렌더링:뷰를통해서뷰를렌더링한다.

#### 인터페이스 살펴보기
* 스프링 MVC의 큰 강점은 DispatcherServlet 코드의 변경 없이, 원하는 기능을 변경하거나 확장할 수 있다는 점이다. 지금까지 설명한 대부분을 확장 가능할 수 있게 인터페이스로 제공한다.
이 인터페이스들만 구현해서 DispatcherServlet 에 등록하면 여러분만의 컨트롤러를 만들 수도 있다.

#### HandlerMapping(핸들러 매핑)
* 핸들러 매핑에서 이 컨트롤러를 찾을 수 있어야 한다.
예) 스프링 빈의 이름으로 핸들러를 찾을 수 있는 핸들러 매핑이 필요하다.

#### HandlerAdapter(핸들러 어댑터)
* 핸들러 매핑을 통해서 찾은 핸들러를 실행할 수 있는 핸들러 어댑터가 필요하다.
예) `Controller` 인터페이스를 실행할 수 있는 핸들러 어댑터를 찾고 실행해야 한다.

#### 조합
* 컨트롤러 클래스를 통합하는 것을 넘어서 조합도 가능하다.
* 다음 코드는 `/springmvc/v2/members` 라는 부분에 중복이 있다.
* `@RequestMapping("/springmvc/v2/members/new-form")`
* `@RequestMapping("/springmvc/v2/members")`
* `@RequestMapping("/springmvc/v2/members/save")`
#### 조합 결과
* `클래스 레벨 @RequestMapping("/springmvc/v2/members")`
* `메서드 레벨 @RequestMapping("/new-form")` -> `/springmvc/v2/members/new-form` 
* `메서드 레벨 @RequestMapping("/save")` ->  `/springmvc/v2/members/save`
* `메서드 레벨 @RequestMapping` -> `/springmvc/v2/members`