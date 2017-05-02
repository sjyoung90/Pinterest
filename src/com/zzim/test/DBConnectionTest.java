package com.zzim.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.zzim.db.DBConnection;

public class DBConnectionTest {

	@Test
	public void test() {
		DBConnection db = new DBConnection();
		assertEquals(db.getConnection(), true);
	}

}
