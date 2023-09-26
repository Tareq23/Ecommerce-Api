package com.research.project.repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.research.project.entity.CategoryEntity;
import com.research.project.model.home.CategoryModel;
import com.research.project.projections.CategoryProjection;
import com.research.project.projections.ProductProjection;

@Repository
@EnableJpaRepositories
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
	
//	@Query("select new com.foo.bar.entity.Document(d.docId, d.filename) from Document d where d.filterCol = ?1")
//	List<Document> findDocumentsForListing(String filterValue);
	
//	@Query(value="SELECT new com.research.project.entity.CategoryEntity(ce.id, ce.name, ce.imageUrl) from categories ce",nativeQuery = true)
//	@Query("SELECT new com.research.project.entity.CategoryEntity(ce.id, ce.name, ce.imageUrl) from categories ce")
//	public Set<CategoryEntity> getOnlyCategory();
	
//	@Query("SELECT new com.research.project.entity.CategoryEntity(ce.id, ce.name, ce.imageUrl) from categories ce where id=?1")
//	public CategoryEntity findOnlyCategory(BigInteger id);
	
//	@Modifying
//	@Query("DELETE from products p where category_id=?1")
//	public int deleteCategoryProduct(Long id);
	
//	public CategoryEntity getOnlySingleCategoryById(Long id);
	
	
	
	@Query( "select new com.research.project.projections.CategoryProjection( c.id, c.name, c.imageUrl ) from categories c")
	List<CategoryProjection> showAllCategory();
	
	
	@Query("select new com.research.project.entity.CategoryEntity( c.id, c.name, c.imageUrl, count(p.category) ) from categories c inner join c.products p group by c.id")
	List<CategoryEntity> getAllCategory();
}
