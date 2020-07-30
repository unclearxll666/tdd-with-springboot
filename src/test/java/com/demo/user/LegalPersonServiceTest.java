package com.demo.user;

import com.demo.BaseTest;
import com.essContext.controller.request.LegalPersonRequest;
import com.essContext.domain.model.LegalPerson;
import com.essContext.domain.service.LegalPersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author xiell
 * @version V1.0
 * @ClassName: LegalPersonServiceTest
 * @Description: 法人注册测试类
 * @date 2020/07/25
 */
public class LegalPersonServiceTest extends BaseTest {

    @Autowired
    LegalPersonService legalPersonService;

    @Test
    void should_return_services_success_when_register_given_legalPerson_info() throws Exception {
        LegalPersonRequest legalPersonRequest = new LegalPersonRequest();
        legalPersonRequest.setIdCode("Q55699331123");
        legalPersonRequest.setIdType("222");
        legalPersonRequest.setCompanyCode("324234234231MM12E");
        legalPersonRequest.setCompanyName("吉林公司");
        legalPersonRequest.setName("张三");
        legalPersonRequest.setType("1");

        LegalPerson legalPerson = legalPersonService.register(legalPersonRequest);

        assertTrue(legalPerson.getId().length()>0);
    }

    @Test
    void shoule_return_services_success_when_register_given_certcardno_info() throws Exception {
        LegalPersonRequest legalPersonRequest = new LegalPersonRequest();
        legalPersonRequest.setIdCode("220381198801010201");
        legalPersonRequest.setIdType("111");
        legalPersonRequest.setCompanyCode("324234234231MM12E");
        legalPersonRequest.setCompanyName("吉林公司");
        legalPersonRequest.setName("张三");
        legalPersonRequest.setType("1");

        LegalPerson legalPerson = legalPersonService.register(legalPersonRequest);

        assertTrue(legalPerson.getId().length()>0);
    }

    @Test
    void shoule_return_services_success_when_register_given_password_info() throws Exception {
        LegalPersonRequest legalPersonRequest = new LegalPersonRequest();
        legalPersonRequest.setIdCode("W1225112231121");
        legalPersonRequest.setIdType("222");
        legalPersonRequest.setCompanyCode("A101101001111111");
        legalPersonRequest.setCompanyName("长春公司");
        legalPersonRequest.setName("李四");
        legalPersonRequest.setType("1");

        LegalPerson legalPerson = legalPersonService.register(legalPersonRequest);

        assertTrue(legalPerson.getId().length()>0);
    }

    @Test
    void should_retrun_unsucess_legalperson_empty() throws Exception{
        LegalPersonRequest legalPersonRequest = new LegalPersonRequest();
        legalPersonRequest.setIdCode("W1225112231121");
        legalPersonRequest.setIdType("222");
        legalPersonRequest.setCompanyCode("");
        legalPersonRequest.setCompanyName("");
        legalPersonRequest.setName("李四");
        legalPersonRequest.setType("1");

        LegalPerson legalPerson = legalPersonService.register(legalPersonRequest);

        assertTrue(legalPerson.getId().length()<0);
    }


    @Test
    void should_retrun_unsucess_companyname_error() throws Exception{
        LegalPersonRequest legalPersonRequest = new LegalPersonRequest();
        legalPersonRequest.setIdCode("W1225112231121");
        legalPersonRequest.setIdType("222");
        legalPersonRequest.setCompanyCode("AS231351523512232");
        legalPersonRequest.setCompanyName("长春名称长春名称长春名称长春名称长春名称长春名称长春名称长春名称长春名称长春名称长春名称");
        legalPersonRequest.setName("李四");
        legalPersonRequest.setType("1");

        LegalPerson legalPerson = legalPersonService.register(legalPersonRequest);

        assertTrue(legalPerson.getId().length()<0);
    }


    @Test
    void should_return_legalperson_name_error() throws Exception {

        LegalPersonRequest legalPersonRequest = new LegalPersonRequest();
        legalPersonRequest.setIdCode("W1225112231121");
        legalPersonRequest.setIdType("222");
        legalPersonRequest.setCompanyCode("AS231351523512232");
        legalPersonRequest.setCompanyName("长春名称长春名称长春名称长春名称长春名称长春名称长春名称长春名称长春名称长春名称长春名称");
        legalPersonRequest.setName("李四");
        legalPersonRequest.setType("1");

        LegalPerson legalPerson = legalPersonService.register(legalPersonRequest);

        assertTrue(legalPerson.getId().length()<0);

    }

    // 人姓名为空或者大于20位
    @Test
    void should_retrun_unsucess_legalperson_name_length() throws Exception{

        LegalPersonRequest legalPersonRequest = new LegalPersonRequest();
        legalPersonRequest.setIdCode("W1225112231121");
        legalPersonRequest.setIdType("222");
        legalPersonRequest.setCompanyCode("AS231351523512232");
        legalPersonRequest.setCompanyName("长春企业");
        legalPersonRequest.setName("李四李四李四李四李四李四李四李四李四李四李四李四李四李四李四李四李四李四李四李四李四李四李四李四李四李四李四李四李四李四李四");
        legalPersonRequest.setType("1");

        LegalPerson legalPerson = legalPersonService.register(legalPersonRequest);

        assertTrue(legalPerson.getId().length()<0);


    }

    // 统一社会信用代码 ！= 18 位
    @Test
    void should_return_unsucess__creditcode_length() throws Exception{
        LegalPersonRequest legalPersonRequest = new LegalPersonRequest();
        legalPersonRequest.setIdCode("W1225112231121");
        legalPersonRequest.setIdType("222");
        legalPersonRequest.setCompanyCode("DSS123456789012345678QWE");
        legalPersonRequest.setCompanyName("长春企业");
        legalPersonRequest.setName("王五");
        legalPersonRequest.setType("1");

        LegalPerson legalPerson = legalPersonService.register(legalPersonRequest);

        assertTrue(legalPerson.getId().length()<0);
    }

    // 法人证件类型为身份证，且证件号码不等于18位
    @Test
    void should_return_unsucess_legalperson_id_number_length() throws Exception{
        LegalPersonRequest legalPersonRequest = new LegalPersonRequest();
        legalPersonRequest.setIdCode("220381198807051111111111");
        legalPersonRequest.setIdType("111");
        legalPersonRequest.setCompanyCode("DSS123456789012345678QWE");
        legalPersonRequest.setCompanyName("长春企业");
        legalPersonRequest.setName("王五");
        legalPersonRequest.setType("1");

        LegalPerson legalPerson = legalPersonService.register(legalPersonRequest);

        assertTrue(legalPerson.getId().length()<0);
    }

    // 法人证件类型为护照，且证件号码不等于14位
    @Test
    void should_return_unsucess_legalperson_passport_number_length() throws Exception{
        LegalPersonRequest legalPersonRequest = new LegalPersonRequest();
        legalPersonRequest.setIdCode("Q122331211111121111");
        legalPersonRequest.setIdType("222");
        legalPersonRequest.setCompanyCode("DSS123456789012345678QWE");
        legalPersonRequest.setCompanyName("长春企业");
        legalPersonRequest.setName("王五");
        legalPersonRequest.setType("1");

        LegalPerson legalPerson = legalPersonService.register(legalPersonRequest);

        assertTrue(legalPerson.getId().length()<0);
    }

    // 法人证件类型与系统不符
    @Test
    void should_return_unsucess_legalperson_id_type() throws Exception{
        LegalPersonRequest legalPersonRequest = new LegalPersonRequest();
        legalPersonRequest.setIdCode("220381198807052210");
        legalPersonRequest.setIdType("585");
        legalPersonRequest.setCompanyCode("DSS123456789012345678QWE");
        legalPersonRequest.setCompanyName("长春企业");
        legalPersonRequest.setName("王五");
        legalPersonRequest.setType("1");

        LegalPerson legalPerson = legalPersonService.register(legalPersonRequest);

        assertTrue(legalPerson.getId().length()<0);
    }

    // 用已注册统一社会信用代码
    @Test
    void should_return_unsucess_exists_registed_creditcode() throws Exception {

        LegalPersonRequest legalPersonRequest = new LegalPersonRequest();
        legalPersonRequest.setIdCode("Q55699331123");
        legalPersonRequest.setIdType("222");
        legalPersonRequest.setCompanyCode("324234234231MM12E");
        legalPersonRequest.setCompanyName("吉林公司");
        legalPersonRequest.setName("张三");
        legalPersonRequest.setType("1");

        LegalPerson legalPerson = legalPersonService.register(legalPersonRequest);

        assertTrue(legalPerson.getId().length() < 0);

    }
}