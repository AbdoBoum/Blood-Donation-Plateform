package DAO.InterfacesImpl;

import DAO.DAOFactory;
import DAO.Interfaces.BlogDao;
import Models.Blog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BlogDaoImpl implements BlogDao {

    private DAOFactory daoFactory;

    public BlogDaoImpl(DAOFactory daoFactory){
        this.daoFactory = daoFactory;
    }

    @Override
    public Blog insertBlog(Blog blog) {
        Connection connection = null;
        PreparedStatement statement = null;
        PreparedStatement statement1 = null;
        ResultSet resultSet = null;

        try {
            /* etablish the connection and execute the query to add blog*/
            connection = daoFactory.getConnection();
            statement = connection.prepareStatement("Insert into Blog (titre_blog, contenue_blog, pathImg_blog, id_donnateur, date_blog) values (?, ?, ?, ?, ?)");
            statement.setString(1, blog.getTitreBlog());
            statement.setString(2, blog.getContenueBlog());
            statement.setString(3, blog.getPathImgBlog());
            statement.setInt(4, blog.getIdDonateur());
            statement.setTimestamp(5, blog.getDateBlog());
            statement.executeUpdate();

            /* the id is auto_increment so we have to take it from the data base and it will be the last id inserted(max)*/
            statement1 = connection.prepareStatement("select MAX(id_blog) AS MAXID , date_blog AS DateBlog  from Blog");
            resultSet = statement1.executeQuery();
            if(resultSet.next()){
                blog.setIdBlog(resultSet.getInt("MAXID"));
            }

            /* close preparedStatement */
            statement.close();
            statement1.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return blog;
    }

    @Override
    public List<Blog> FetchBlogByTitle(String title) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Blog blog ;
        List<Blog> blogs = new ArrayList<Blog>();

        try{
            /* etablish the connection and search all the matching blogs from database*/
            connection = daoFactory.getConnection();
            statement = connection.prepareStatement("Select * from Blog where titre_blog like ?");
            statement.setString(1, "%" + title + "%");
            resultSet = statement.executeQuery();
            exctractInfos(blogs, resultSet);
            statement.close();
            return blogs;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Blog fetchBlogById(int idBlog) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Blog blog ;

        try{
            /* etablish the connection and search the blogs from whith the same id*/
            connection = daoFactory.getConnection();
            statement = connection.prepareStatement("Select * from Blog where id_blog = ?");
            statement.setInt(1, idBlog);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                blog = new Blog();
                blog.setIdBlog(resultSet.getInt(1));
                blog.setTitreBlog(resultSet.getString(2));
                blog.setContenueBlog(resultSet.getString(3));
                blog.setPathImgBlog(resultSet.getString(4));
                blog.setIdDonateur(resultSet.getInt(5));
                blog.setDateBlog(resultSet.getTimestamp(6));
                statement.close();
                return blog;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Blog> getAllBlogs() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Blog> blogs = new ArrayList<Blog>();

        try{
            /* etablish the connection and search all blogs from database*/
            connection = daoFactory.getConnection();
            statement = connection.prepareStatement("SELECT * FROM Blog");
            resultSet = statement.executeQuery();

            /* extact blogs and put theme in the list */
            exctractInfos(blogs, resultSet);

            /* close preparedStatement */
            statement.close();
            return blogs;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Blog updateBlog(Blog blog) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            /* etablish the connection and update the blog*/
            connection = daoFactory.getConnection();
            statement = connection.prepareStatement("UPDATE Blog set titre_blog = ?, contenue_blog = ?, pathImg_blog = ? where id_blog = ?");
            statement.setString(1, blog.getTitreBlog());
            statement.setString(2, blog.getContenueBlog());
            statement.setString(3, blog.getPathImgBlog());
            statement.setInt(4, blog.getIdBlog());
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return blog;
    }

    @Override
    public boolean deleteBlog(int idBlog) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = daoFactory.getConnection();
            statement = connection.prepareStatement("delete FROM Blog where id_blog = ?");
            statement.setInt(1, idBlog);
            statement.executeUpdate();
            statement.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Blog> getBlogByPagination(int PageNumber) {
        return null;
    }

    /* method to extract information from Blog table and put theme into a list*/
    public void exctractInfos(List<Blog> blogs, ResultSet resultSet) throws SQLException {
        while (resultSet.next()){
            Blog blog = new Blog();
            blog.setIdBlog(resultSet.getInt(1));
            blog.setTitreBlog(resultSet.getString(2));
            blog.setContenueBlog(resultSet.getString(3));
            blog.setPathImgBlog(resultSet.getString(4));
            blog.setIdDonateur(resultSet.getInt(5));
            blog.setDateBlog(resultSet.getTimestamp(6));
            blogs.add(blog);
        }
    }
}
