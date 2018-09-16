package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public final class Forum {

    private final List<ForumUser> theForumUserList;

    Forum(ForumDatabase forumDatabase) {
        this.theForumUserList = forumDatabase.getUsers();
    }

    List<ForumUser> getTheForumUserList() {
        return new ArrayList<>(theForumUserList);
    }
}
