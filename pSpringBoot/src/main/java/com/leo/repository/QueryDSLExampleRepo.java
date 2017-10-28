package com.leo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.leo.entity.Course;
import com.leo.entity.QCourse;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;

@Repository("queryDSLExampleRepo")
public class QueryDSLExampleRepo {
	private QCourse qCourse = QCourse.course;

	@PersistenceContext
	private EntityManager entityManager;

	public void find() {
		JPAQuery<Course> query = new JPAQuery<Course>(entityManager);

		// consultar un curso: solo las columnas name y description
		Course course = (Course) query.select(qCourse.name, qCourse.description).from(qCourse).where(qCourse.id.eq(23))
				.fetchOne();

		// consultar una lista de cursos: devuelve todas las columnas
		List<Course> courses = query.select(qCourse).from(qCourse).where(qCourse.hours.between(20, 50)).fetch();

	}

	public Course find(boolean exist) {
		JPAQuery<Course> query = new JPAQuery<Course>(entityManager);

		BooleanBuilder predicateBuilder = new BooleanBuilder(qCourse.description.endsWith("OP"));
		if (exist) {
			Predicate predicate2 = qCourse.id.eq(23);
			predicateBuilder.and(predicate2);
		} else {
			Predicate predicate3 = qCourse.name.endsWith("OP");
			predicateBuilder.or(predicate3);
		}
		// consultar un curso
		return (Course) query.select(qCourse.name, qCourse.description).from(qCourse).where(predicateBuilder).fetchOne();
	}
}
