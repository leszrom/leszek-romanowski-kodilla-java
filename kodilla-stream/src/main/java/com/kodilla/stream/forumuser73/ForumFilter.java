package com.kodilla.stream.forumuser73;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class ForumFilter {
    static List<ForumUser> getMaleForumUsers(List<ForumUser> userList) {
        List<ForumUser> maleUsers = userList.stream()
                .filter(user -> user.getSex() == 'M')
                .collect(Collectors.toList());

        maleUsers.forEach(System.out::println);

        return maleUsers;
    }

    static List<ForumUser> getForumUsersAtLeast20YearsOld(List<ForumUser> userList) {
        List<ForumUser> usersAtLeast20YearsOld = userList.stream()
                .filter(user -> Period.between(user.getDateOfBirth(), LocalDate.now()).getYears() >= 20)
                .collect(Collectors.toList());

        usersAtLeast20YearsOld.forEach(System.out::println);

        return usersAtLeast20YearsOld;
    }

    static List<ForumUser> getForumUsersWithAtLeast1Post(List<ForumUser> userList) {
        List<ForumUser> usersWithAtLeast1Post = userList.stream()
                .filter(user -> user.getNumberOfPosts() > 0)
                .collect(Collectors.toList());

        usersWithAtLeast1Post.forEach(System.out::println);

        return usersWithAtLeast1Post;
    }

    static Map<Integer, ForumUser> getMapOfForumUsers(List<ForumUser> userList) {
        Map<Integer, ForumUser> mapOfForumUsers = userList.stream()
                .collect(Collectors.toMap(ForumUser::getUserID, user -> user));

        mapOfForumUsers.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue().getUsername() + ", " + entry.getValue().getDateOfBirth())
                .forEach(System.out::println);

        return mapOfForumUsers;
    }


}
