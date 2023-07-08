
`MultiValueMap`
  * MAP과 유사한데, 하나의 키에 여러 값을 받을 수 있다.
  * HTTP header, HTTP 쿼리 파라미터와 같이 하나의 키에 여러 값을 받을 때 사용한다.
   * `keyA=value1&keyA=value2`
> `MultiValueMap<String, String> map = new LinkedMultiValueMap();
   map.add("keyA", "value1");
   map.add("keyA", "value2");
   //[value1,value2]
   List<String> values = map.get("keyA");`

**@Slf4j**
* 다음 코드를 자동으로 생성해서 로그를 선언해준다.
* 개발자는 편리하게 log 라고 사용하면 된다. 
> `private static final org.slf4j.Logger log =
   org.slf4j.LoggerFactory.getLogger(RequestHeaderController.class);`