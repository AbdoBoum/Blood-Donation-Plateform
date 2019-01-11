package DAO.Tests;

import DAO.DAOFactory;
import DAO.InterfacesImpl.BlogDaoImpl;
import Models.Blog;

import java.util.Date;
import java.util.List;

public class BlogTest {
    public static void main(String[] args){
        BlogDaoImpl dao = new BlogDaoImpl(DAOFactory.getInstance());
        Blog b1 = dao.insertBlog(new Blog("Slider", "Slider is a noob man", "https", 5, new java.sql.Timestamp(new Date().getTime())));
        Blog b2 = dao.insertBlog(new Blog("Bodle", "Bodle is a riche man", "httpds", 5, new java.sql.Timestamp(new Date().getTime())));
        Blog b3 = dao.insertBlog(new Blog("xx", "Bodle is a riche man", "httpds", 5, new java.sql.Timestamp(new Date().getTime())));
        b1.setPathImgBlog("zhwani");
        dao.updateBlog(b1);
        List<Blog> blogs = dao.FetchBlogByTitle("l");
        for(Blog b: blogs){
            System.out.println(b.toString());
        }
    }
}
