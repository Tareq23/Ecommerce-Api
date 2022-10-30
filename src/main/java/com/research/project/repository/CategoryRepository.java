package com.research.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.research.project.entity.CategoryEntity;
import com.research.project.model.home.CategoryModel;

@Repository
@EnableJpaRepositories
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
	
//	@Query("select new com.foo.bar.entity.Document(d.docId, d.filename) from Document d where d.filterCol = ?1")
//	List<Document> findDocumentsForListing(String filterValue);
	
//	@Query(value="SELECT new com.research.project.entity.CategoryEntity(ce.id, ce.name, ce.imageUrl) from categories ce",nativeQuery = true)
	@Query("SELECT new com.research.project.entity.CategoryEntity(ce.id, ce.name, ce.imageUrl) from categories ce")
	public List<CategoryEntity> getOnlyCategory();
}
