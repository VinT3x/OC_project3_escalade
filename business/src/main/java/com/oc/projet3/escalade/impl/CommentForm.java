package com.oc.projet3.escalade.impl;

import javax.validation.constraints.NotNull;

public class CommentForm {

    @NotNull
    private String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


}
