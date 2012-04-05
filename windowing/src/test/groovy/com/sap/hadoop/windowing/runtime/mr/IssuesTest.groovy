package com.sap.hadoop.windowing.runtime.mr;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sap.hadoop.windowing.MRBaseTest;

/**
 * Based on issues reported on GitHub
 *
 */
class IssuesTest extends MRBaseTest
{

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
}