package com.pccw.user;

import com.pccw.user.common.ApiResponse;
import com.pccw.user.req.QueryUserReq;
import com.pccw.user.req.UserReq;
import com.pccw.user.resp.UserResp;
import com.pccw.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class UserDemo1ApplicationTests {

	@Autowired
	private UserService userService;
	@Test
	void contextLoads() {
	}

	@Test
	void testFindAll(){
		QueryUserReq queryUserReq = new QueryUserReq();
		queryUserReq.setId(1L);
		ApiResponse<UserResp> userResp = userService.queryUserById(queryUserReq);
		System.out.println(userResp);
	}

	@Test
	void testQueryUserById(){
		QueryUserReq queryUserReq = new QueryUserReq();
		queryUserReq.setId(1L);
		ApiResponse<UserResp> userResp = userService.queryUserById(queryUserReq);
		System.out.println(userResp);
	}

	@Test
	void testInsertUser(){
		UserReq userReq = new UserReq();
		userReq.setUserName("aa");
		userReq.setEmail("bb");
		ApiResponse<Long> userIdResp = userService.insertUser(userReq);
		System.out.println(userIdResp);
	}

	@Test
	void testUpdateUser(){
		UserReq userReq = new UserReq();
		userReq.setId(1L);
		userReq.setUserName("aa");
		userReq.setEmail("bb");
		ApiResponse resp = userService.updateUser(userReq);
		System.out.println(resp);
	}
	@Test
	void testDeleteUser(){
		QueryUserReq queryUserReq = new QueryUserReq();
		queryUserReq.setId(1L);
		ApiResponse resp = userService.deleteUser(queryUserReq);
		System.out.println(resp);
	}


}
