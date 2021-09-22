package com.paladin.account;

import com.paladin.account.config.convert.UserMapper;
import com.paladin.account.dto.UserDTO;
import com.paladin.account.dto.UserVO;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

@SpringBootTest
class AccountApplicationTests {

	@Test
	void contextLoads() {

	}

	/**
	 * 测试各种属性拷贝工具的性能
	 */
	@Test
	public void testMapStructPropertyCopy(){
		UserDTO userDTO = buildUserDTO();
		System.out.println(userDTO.toString());

		UserVO userVO = UserMapper.INSTANCE.userVOToUserDTO(userDTO);
		System.out.println("result is convert success");
		System.out.println(userVO);
	}

	@Test
	public void testSpringBeanUtilsPropertyCopy(){
		UserDTO userDTO = buildUserDTO();
		System.out.println(userDTO.toString());


		UserVO userVO = new UserVO();
		BeanUtils.copyProperties(userDTO, userVO);
		System.out.println("result is convert success");
		System.out.println(userVO);
	}

	@Test
	public void testApacheBeanUtilsPropertyCopy(){
		UserDTO userDTO = buildUserDTO();
		System.out.println(userDTO.toString());


		UserVO userVO = new UserVO();
		try {
			BeanUtilsBean.getInstance().copyProperties(userVO, userDTO);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		System.out.println("result is convert success");
		System.out.println(userVO);
	}

	private UserDTO buildUserDTO() {
		UserDTO userDTO = new UserDTO();
		userDTO.setAddress("广东省深圳市龙岗区下李朗公园(水官高速公路北");
		userDTO.setPhoneNum("13098782345");
		userDTO.setBirthDay("20210424");
		userDTO.setAge(20);
		userDTO.setCountNo("86");
		userDTO.setCredit(new BigDecimal(2000.00));
		userDTO.setCreditNO(6222873902087784l);
		userDTO.setUsername("张三");
		userDTO.setEmail("382995320482@qq.com");
		userDTO.setHoby("bodybuilding");
		userDTO.setInterest("FinancialTest");
		userDTO.setJob("programmer");
		userDTO.setSalary(20000.00f);
		userDTO.setNation("China");
		userDTO.setNote("i love coding,coding makes me happy");
		userDTO.setRent(2100.00);
		userDTO.setRoom((short)2401);
		userDTO.setSex((byte) 1);
		userDTO.setWebsite("www.goodserendipity");
		return userDTO;
	}

}
