package mem.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.management.RuntimeErrorException;

public class memDAO implements memDAO_interface{

	String driver ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url ="jdbc:sqlserver://localhost:1433;DataBaseName=Spractice";
	String userid ="sa";
	String pswd ="sa123456";
	
	private static final String INSERT ="INSERT INTO member(mem_name,mem_account,mem_password) Values(?,?,?)";
	private static final String finalAll="SELECT mem_id,mem_name,mem_account,mem_password From member order by mem_id ";
	private static final String update="UPDATE member set mem_name=?,mem_account=?,mem_password=? where  mem_id=? ";
	
	
	@Override
	public void insert(memVO memvo) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, pswd);
			pstmt = conn.prepareStatement(INSERT);
			pstmt.setString(1, memvo.getMem_name());
			pstmt.setString(2, memvo.getMem_account());
			pstmt.setString(3, memvo.getMem_password());
			
			pstmt.executeUpdate();
			
		}catch (SQLException e) {
		throw new RuntimeException("error"+e.toString());
			
		}catch (ClassNotFoundException e) {
			throw new RuntimeException("error"+e.toString());
		}finally{
			if(pstmt!=null){
				try{
					pstmt.close();
				}catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
		}
		
		
	}

	@Override
	public void updata(memVO memvo) {
		Connection conn =null;
		PreparedStatement pstmt=null;
		try{
			Class.forName(driver);
			conn =DriverManager.getConnection(url, userid, pswd);
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1,memvo.getMem_name() );
			pstmt.setString(2,memvo.getMem_account() );
			pstmt.setString(3,memvo.getMem_password() );
			pstmt.setInt(4,memvo.getMem_id() );
			
			int count =pstmt.executeUpdate();
			if(count==0){
				throw new RuntimeException();
			}
			
		}catch (SQLException e) {
			throw new RuntimeException("Error"+e.getMessage());
		} catch (ClassNotFoundException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
		}
		
		
	}

	@Override
	public void delete(memVO memvo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<memVO> findAll() {
		List<memVO> list=new ArrayList<memVO>();
		Connection conn =null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		try{
			Class.forName(driver);
			conn =DriverManager.getConnection(url, userid, pswd);
			pstmt = conn.prepareStatement(finalAll);
			rs= pstmt.executeQuery();
			System.out.println(rs);
//			list=new Vector<>();
			while(rs.next()){
				memVO mVO=new memVO(); 
				mVO.setMem_id(rs.getInt("mem_id"));
				mVO.setMem_name(rs.getNString("mem_name"));
				mVO.setMem_account(rs.getNString("mem_account"));
				mVO.setMem_password(rs.getNString("mem_password"));
				list.add(mVO);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} 
		}
		
		return list;
	}
	
}
