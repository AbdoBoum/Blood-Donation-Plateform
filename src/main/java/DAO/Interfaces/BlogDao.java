package DAO.Interfaces;


import Models.Blog;

import java.util.List;

public interface BlogDao {

    final int limit = 6;

    /* insert a blog*/
    public Blog insertBlog(Blog blog);

    /* fetch a blog by title: may return multiple blogs*/
    public List<Blog> FetchBlogByTitle(String title);

    /* fetch a blog by id*/
    public Blog fetchBlogById(int idBlog);

    /* fetch a blog by id*/
    public List<Blog> getAllBlogs();

    /* update a blog */
    public Blog updateBlog(Blog blog);

    /* delete  a blog*/
    public boolean deleteBlog(int idBlog);

    /* get 6 blog by page*/
    public List<Blog> getBlogByPagination(int start, int total);

    /* to get number of blogs */
    public int CountBlogs();

    /* to get author of the blog */
    public String getBlogAuthor(int id);

    /* get 6 blog by page*/
    public List<Blog> getBlogByPaginationKeyword(int start, int total, String keyword);
}
