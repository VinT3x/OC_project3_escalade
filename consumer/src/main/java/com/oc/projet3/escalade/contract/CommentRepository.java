package com.oc.projet3.escalade.contract;

import com.oc.projet3.escalade.entities.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
//    @Query("SELECT c.comment_id, c.commentvalue, c.createddate from Comment c INNER JOIN Topo_comment tc on c.comment_id = tc.comment_id INNER JOIN Topo t on tc.topo_id = t.id where t.id=:id")
//    public List<Comment> findAllComments(@Param("id") Long id);
}
