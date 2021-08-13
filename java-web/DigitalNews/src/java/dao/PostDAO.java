/*
 * Copyright (C) 2021, FPT University<br>
 * J3.L.P0004<br>
 * DigitalNews<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 2021-07-01    1.0        DatDuyTran       Release 1.0<br>
 */
package dao;

import java.util.List;
import model.Post;

/**
 *
 * @author DatDuyTran
 */
public interface PostDAO {

    /**
     * Get the latest posts
     *
     * @return a <code>Post</code> object
     * @throws Exception
     */
    public Post getLastest() throws Exception;

    /**
     * Get all latest posts by the given number
     *
     * @param numberOfPosts a number of posts you want to get, as
     * <code>int</code>
     * @return a <code>List</code> of <code>Post</code>, if it does not exists,
     * return null
     * @throws Exception
     */
    public List<Post> getListOfLatests(int numberOfPosts) throws Exception;

    /**
     * Get a post by its id
     *
     * @param id a post id, as <code>int</code> number
     * @return a <code>Post</code> object
     * @throws Exception
     */
    public Post getById(int id) throws Exception;

    /**
     * Search all posts in the database by keywords, from its
     * <pre>title</pre> and
     * <pre>content</pre>
     *
     * @param keyword a <code>String</code>
     * @return a <code>List</code> of <code>Post</code>
     * @throws Exception
     */
    public List<Post> search(String keyword) throws Exception;
}
