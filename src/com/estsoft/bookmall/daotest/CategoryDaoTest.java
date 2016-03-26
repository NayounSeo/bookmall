package com.estsoft.bookmall.daotest;

import java.util.List;

import com.estsoft.bookmall.dao.CategoryDao;
import com.estsoft.bookmall.dao.CategoryDao;
import com.estsoft.bookmall.vo.CategoryVo;
import com.estsoft.bookmall.vo.CategoryVo;
//Test 순서는 category - book - member - cart - order 순으로 진행했습니다.
public class CategoryDaoTest {
	public static void main(String[] args) {
		//insert test
		insertTest();
		//getList test
		getListTest();
	}

	public static void getListTest() {
		List<CategoryVo> list = new CategoryDao().getList();
		for( CategoryVo categoryVo : list ) {
			System.out.println( categoryVo );
		}
	}
	
	public static void insertTest() {
		CategoryVo categoryVo = new CategoryVo();
		CategoryDao categoryDao = new CategoryDao();
		
		categoryVo.setCategoryId(1L);
		categoryVo.setCategoryName("Fiction");
		categoryDao.insert(categoryVo);
		
		categoryVo.setCategoryId(2L);
		categoryVo.setCategoryName("IT");
		categoryDao.insert(categoryVo);

		categoryVo.setCategoryId(3L);
		categoryVo.setCategoryName("Humanities");
		categoryDao.insert(categoryVo);

		categoryVo.setCategoryId(4L);
		categoryVo.setCategoryName("Art");
		categoryDao.insert(categoryVo);
	}

}
