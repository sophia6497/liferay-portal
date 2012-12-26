/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.dao.orm;

import com.liferay.portal.dao.db.OracleDB;
import com.liferay.portal.dao.db.PostgreSQLDB;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBFactoryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.test.ExecutionTestListeners;
import com.liferay.portal.service.persistence.PersistenceExecutionTestListener;
import com.liferay.portal.test.LiferayPersistenceIntegrationJUnitTestRunner;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Shuyang Zhou
 */
@ExecutionTestListeners(listeners = {
	PersistenceExecutionTestListener.class})
@RunWith(LiferayPersistenceIntegrationJUnitTestRunner.class)
public class NullTest {

	@Test
	public void testBlankStringIsNotNull() {

		// ('' is not null) is true, expect for Oracle

		Session session = _sessionFactory.openSession();

		try {
			SQLQuery sqlQuery = session.createSQLQuery(_blankStringIsNotNull);

			List<Object> list = sqlQuery.list();

			DB db = DBFactoryUtil.getDB();

			if (db instanceof OracleDB) {
				Assert.assertTrue(list.isEmpty());
			}
			else {
				Assert.assertFalse(list.isEmpty());
			}
		}
		finally {
			session.close();
		}
	}

	@Test
	public void testBlankStringIsNull() {

		// ('' is null) is false, expect for Oracle

		Session session = _sessionFactory.openSession();

		try {
			SQLQuery sqlQuery = session.createSQLQuery(_blankStringIsNull);

			List<Object> list = sqlQuery.list();

			DB db = DBFactoryUtil.getDB();

			if (db instanceof OracleDB) {
				Assert.assertFalse(list.isEmpty());
			}
			else {
				Assert.assertTrue(list.isEmpty());
			}
		}
		finally {
			session.close();
		}
	}

	@Test
	public void testBlankStringLikeNull() {

		// Nothing likes null, nothing does not like null

		// ('' like null) is false for all databases

		Session session = _sessionFactory.openSession();

		try {
			SQLQuery sqlQuery = session.createSQLQuery(_blankStringLikeNull);

			List<Object> list = sqlQuery.list();

			Assert.assertTrue(list.isEmpty());
		}
		finally {
			session.close();
		}
	}

	@Test
	public void testBlankStringNotLikeNull() {

		// Nothing likes null, nothing does not like null

		// ('' not like null) is false for all databases

		Session session = _sessionFactory.openSession();

		try {
			SQLQuery sqlQuery = session.createSQLQuery(_blankStringNotLikeNull);

			List<Object> list = sqlQuery.list();

			Assert.assertTrue(list.isEmpty());
		}
		finally {
			session.close();
		}
	}

	@Test
	public void testNullIsNotNull() {

		// (null is not null) is false for all databases

		Session session = _sessionFactory.openSession();

		try {
			SQLQuery sqlQuery = session.createSQLQuery(_nullIsNotNull);

			List<Object> list = sqlQuery.list();

			Assert.assertTrue(list.isEmpty());
		}
		finally {
			session.close();
		}
	}

	@Test
	public void testNullIsNull() {

		// (null is null) is true for all databases

		Session session = _sessionFactory.openSession();

		try {
			SQLQuery sqlQuery = session.createSQLQuery(_nullIsNull);

			List<Object> list = sqlQuery.list();

			Assert.assertFalse(list.isEmpty());
		}
		finally {
			session.close();
		}
	}

	@Test
	public void testNullLikeNull() {

		// Nothing likes null, nothing does not like null

		// (null like null) is false for all databases

		Session session = _sessionFactory.openSession();

		try {
			SQLQuery sqlQuery = session.createSQLQuery(_nullLikeNull);

			List<Object> list = sqlQuery.list();

			Assert.assertTrue(list.isEmpty());
		}
		finally {
			session.close();
		}
	}

	@Test
	public void testNullNotLikeNull() {

		// Nothing likes null, nothing does not like null

		// (null not like null) is false for all databases

		Session session = _sessionFactory.openSession();

		try {
			SQLQuery sqlQuery = session.createSQLQuery(_nullNotLikeNull);

			List<Object> list = sqlQuery.list();

			Assert.assertTrue(list.isEmpty());
		}
		finally {
			session.close();
		}
	}

	@Test
	public void testZeroIsNotNull() {

		// (0 is not null) is true for all databases

		Session session = _sessionFactory.openSession();

		try {
			SQLQuery sqlQuery = session.createSQLQuery(_zeroIsNotNull);

			List<Object> list = sqlQuery.list();

			Assert.assertFalse(list.isEmpty());
		}
		finally {
			session.close();
		}
	}

	@Test
	public void testZeroIsNull() {

		// (0 is null) is false for all databases

		Session session = _sessionFactory.openSession();

		try {
			SQLQuery sqlQuery = session.createSQLQuery(_zeroIsNull);

			List<Object> list = sqlQuery.list();

			Assert.assertTrue(list.isEmpty());
		}
		finally {
			session.close();
		}
	}

	@Test
	public void testZeroLikeNull() {

		// Nothing likes null, nothing does not like null

		// (0 like null) is an illegal statement for PostgreSQL

		DB db = DBFactoryUtil.getDB();

		if (db instanceof PostgreSQLDB) {
			return;
		}

		// (0 like null) is false for all other databases

		Session session = _sessionFactory.openSession();

		try {
			SQLQuery sqlQuery = session.createSQLQuery(_zeroLikeNull);

			List<Object> list = sqlQuery.list();

			Assert.assertTrue(list.isEmpty());
		}
		finally {
			session.close();
		}
	}

	@Test
	public void testZeroNotLikeNull() {

		// Nothing likes null, nothing does not like null

		// (0 not like null) is an illegal statement for PostgreSQL

		DB db = DBFactoryUtil.getDB();

		if (db instanceof PostgreSQLDB) {
			return;
		}

		// (0 not like null) is false for all other databases

		Session session = _sessionFactory.openSession();

		try {
			SQLQuery sqlQuery = session.createSQLQuery(_zeroNotLikeNull);

			List<Object> list = sqlQuery.list();

			Assert.assertTrue(list.isEmpty());
		}
		finally {
			session.close();
		}
	}

	private static final String _blankStringIsNotNull =
		"select distinct 1 from ClassName_ where '' is not null";

	private static final String _blankStringIsNull =
		"select distinct 1 from ClassName_ where '' is null";

	private static final String _blankStringLikeNull =
		"select distinct 1 from ClassName_ where '' like null";

	private static final String _blankStringNotLikeNull =
		"select distinct 1 from ClassName_ where '' not like null";

	private static final String _nullIsNotNull =
		"select distinct 1 from ClassName_ where null is not null";

	private static final String _nullIsNull =
		"select distinct 1 from ClassName_ where null is null";

	private static final String _nullLikeNull =
		"select distinct 1 from ClassName_ where null like null";

	private static final String _nullNotLikeNull =
		"select distinct 1 from ClassName_ where null not like null";

	private static final String _zeroIsNotNull =
		"select distinct 1 from ClassName_ where 0 is not null";

	private static final String _zeroIsNull =
		"select distinct 1 from ClassName_ where 0 is null";

	private static final String _zeroLikeNull =
		"select distinct 1 from ClassName_ where 0 like null";

	private static final String _zeroNotLikeNull =
		"select distinct 1 from ClassName_ where 0 not like null";

	private SessionFactory _sessionFactory =
		(SessionFactory)PortalBeanLocatorUtil.locate("liferaySessionFactory");

}