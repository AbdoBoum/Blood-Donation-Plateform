package DAO.Interfaces;


import Models.Blog;

import java.util.List;

public interface BlogDao {

    /* insert a blog*/
    public Blog insertBlog(Blog blog);

    /* fetch a blog by title*/
    public List<Blog> FetchBlogByTitle(String title);

    /* fetch a blog by id*/
    public Blog fetchBlogById(int idBlog);

    /* fetch a blog by id*/
    public List<Blog> getAllBlogs();

    /* update a blog */
    public Blog updateBlog(Blog blog);

    /* delete  a blog*/
    public void deleteBlog(int idBlog);
}
