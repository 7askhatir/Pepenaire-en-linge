package Pepenaire.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Pepenaire.Connect.Connect;
import Pepenaire.Domain.Pepenaire;

public class PepenaireDao extends Connect implements Dao<Pepenaire> {

	@Override
	public Pepenaire getById(int id) {
		Pepenaire s=null;  
	    try{  
	        Connection conn=getConnection();  
	        PreparedStatement ps=conn.prepareStatement("SELECT * FROM `produit` where `id`=?");  
	        ps.setInt(1,id);  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            s=new Pepenaire();  
	            s.setId(rs.getInt("id"));  
	            s.setNom(rs.getString("nom"));  
	            s.setCate(rs.getString("cate"));  
	          
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return s;
	}

	@Override
	public List<Pepenaire> getAll() {
		 List<Pepenaire> list=new ArrayList<Pepenaire>();  
	      
		    try{  
		        Connection conn=getConnection();  
		        PreparedStatement ps=conn.prepareStatement("SELECT * FROM `produit`");  
		        ResultSet rs=ps.executeQuery();  
		        while(rs.next()){  
		        	Pepenaire s=new Pepenaire();  
		            s.setId(rs.getInt("id"));  
		            s.setNom(rs.getString("nom"));  
		            s.setCate(rs.getString("cate"));  
		            list.add(s);  
		        }  
		    }catch(Exception e){System.out.println(e);}  
		    return list;  
	}

	@Override
	public int save(Pepenaire item) {
		
		int status=0;  
	    try{  
	        Connection conn=getConnection();  
	        PreparedStatement ps=conn.prepareStatement(  
	"INSERT INTO `pépinière`.`produit` (`id`, `nom`, `cate`) VALUES (NULL,?, ?);");  
	        ps.setString(1,item.getNom());  
	        ps.setString(2,item.getCate());  
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	}

	@Override
	public int saveAll(List<Pepenaire> items) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Pepenaire item) {
		 int status=0;
 
		 try{
	         Connection con =Connect.getConnection();
	         String query ="UPDATE `pépinière`.`produit` SET `nom` = ?, cate =? where id = ?"; 
	         PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(query);
	         preparedStmt.setInt(3,item.getId());
	         preparedStmt.setString(1,item.getNom());
	         preparedStmt.setString(2,item.getCate());
	         preparedStmt.executeUpdate();
	         status= 1;
	         con.close();
	     }catch(Exception e){
	         System.err.print( e.getClass().getName() + ": " + e.getMessage());
	         status= 0;
	     }
		    return status; 
	}

	@Override
	public int delet(int id) {
		int st=0;  
	    try{  
	        Connection conn=getConnection();  
	        PreparedStatement ps=conn.prepareStatement("DELETE FROM `pépinière`.`produit` WHERE `produit`.`id` = ?");  
	        ps.setInt(1,id);  
	        st=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	  
	    return st;  
	}
	public List<Pepenaire> search(String search) {
		 List<Pepenaire> list=new ArrayList<Pepenaire>();  
	      
		    try{  
		        Connection conn=getConnection();  
		        String sql="SELECT * FROM `produit` WHERE `nom` like '%"+search+"%'";
		        PreparedStatement ps=conn.prepareStatement(sql);  
		        ResultSet rs=ps.executeQuery();  
		        while(rs.next()){  
		        	Pepenaire s=new Pepenaire();  
		            s.setId(rs.getInt("id"));  
		            s.setNom(rs.getString("nom"));  
		            s.setCate(rs.getString("cate"));  
		            list.add(s);  
		        }  
		    }catch(Exception e){System.out.println(e);}  
		    return list;
		
		
	}

}
