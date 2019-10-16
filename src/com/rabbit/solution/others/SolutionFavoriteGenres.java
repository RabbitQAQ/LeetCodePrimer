package com.rabbit.solution.others;

import java.util.*;

public class SolutionFavoriteGenres {
    /*
    userSongs = {
       "David": ["song1", "song2", "song3", "song4", "song8"],
       "Emma":  ["song5", "song6", "song7"]
    },
    songGenres = {
       "Rock":    ["song1", "song3"],
       "Dubstep": ["song7"],
       "Techno":  ["song2", "song4"],
       "Pop":     ["song5", "song6"],
       "Jazz":    ["song8", "song9"]
    }

    Output: {
       "David": ["Rock", "Techno"],
       "Emma":  ["Pop"]
    }
     */
    public static Map<String, List<String>> favoriteGenres(Map<String, List<String>> userSongs, Map<String, List<String>> songGenres) {
        Map<String, List<String>> res = new HashMap<>();
        Map<String, String> nameGenres = new HashMap<>();
        for (String genre : songGenres.keySet()) {
            List<String> songs = songGenres.get(genre);
            for (String song : songs) {
                nameGenres.put(song, genre);
            }
        }
        for (String user: userSongs.keySet()) {
            int max = 0;
            List<String> songs = userSongs.get(user);
            Map<String, Integer> count = new HashMap<>();
            for (String song : songs) {
                String genre = nameGenres.get(song);
                count.put(genre, count.getOrDefault(genre, 0) + 1);
                max = Math.max(max, count.get(genre));
            }
            List<String> tmp = new ArrayList<>();
            for (String genre : count.keySet()) {
                if (count.get(genre).equals(max)) {
                    tmp.add(genre);
                }
            }
            res.put(user, tmp);
        }

        return res;
    }

    public static void main(String[] args) {
        Map<String, List<String>> testUserSongs = new HashMap<>();
        testUserSongs.put("David", Arrays.asList("song1", "song2", "song3", "song4", "song8"));
        testUserSongs.put("Emma", Arrays.asList("song5", "song6", "song7"));
        Map<String, List<String>> testSongGenres = new HashMap<>();
//        testSongGenres.put("Rock", Arrays.asList("song1", "song3"));
//        testSongGenres.put("Dubstep", Arrays.asList("song7"));
//        testSongGenres.put("Techno", Arrays.asList("song2", "song4"));
//        testSongGenres.put("Pop", Arrays.asList("song5", "song6"));
//        testSongGenres.put("Jazz", Arrays.asList("song8", "song9"));
        System.out.println(favoriteGenres(testUserSongs, testSongGenres));
    }
}
