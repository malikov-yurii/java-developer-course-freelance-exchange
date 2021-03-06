package com.malikov.freelance.web.comment;

import com.malikov.freelance.to.CommentTo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/ajax/profile/comments")
public class CommentAjaxController extends AbstractCommentController {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") int id){
        super.delete(id);
    }

    @PostMapping
    public void createOrUpdate(@Valid CommentTo commentTo, @RequestParam("projectId") int projectId){
        if (commentTo.isNew()) {
            super.create(commentTo, projectId);
        } else {
            super.update(commentTo);
        }
    }

}

