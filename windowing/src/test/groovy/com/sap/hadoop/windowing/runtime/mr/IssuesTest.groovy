package com.sap.hadoop.windowing.runtime.mr;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.sap.hadoop.windowing.MRBaseTest;
import com.sap.hadoop.windowing.WindowingException;

/**
 * Based on issues reported on GitHub
 *
 */
class IssuesTest extends MRBaseTest
{
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	/*
	 * create table emp (employee_id int,
		first_name string,
		last_name string,
		email string,
		phone_number string,
		hire_date string,
		job_id string,
		salary int,
		commission_pct double,
		manager_id int,
		department_id int
	)
	row format delimited
	fields terminated by ',';
	 */
	@Test
	void testIssue14()
	{
		wshell.execute("""
		from <select department_id, employee_id, salary from emp>
			partition by department_id
			order by department_id, salary desc
			with rank() as r
			select department_id, employee_id, salary, r
			into path='/tmp/wout'""")
	}
	
	/*
	 * unknown column 'r' in select list not throwing an error.
	 */
	@Test
	void testIssue15()
	{
		expectedEx.expect(WindowingException.class);
		expectedEx.expectMessage("Unknown name 'r' in select list");
		wshell.execute("""
		from emp
partition by department_id
order by department_id, salary desc
select r, department_id, employee_id, salary,
< lag('salary',1) - salary > as salary_gap[int]
into path='/tmp/wout'""")
	}
}