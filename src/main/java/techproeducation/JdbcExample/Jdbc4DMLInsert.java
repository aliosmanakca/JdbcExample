package techproeducation.JdbcExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc4DMLInsert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "hr", "hr");

		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery("SELECT * FROM bolumler");
		while (rs.next()) {
			System.out.println(rs.getInt(1) + rs.getString(2) + rs.getString(3));
		}

		// ORNEK 1: Bolumler tablosuna yeni bir kayit (80, 'ARGE', 'ISTANBUL') ekleyelim
		// ve eklenen kaydi teyit icin sorgulayalim.
		// st.execute("INSERT INTO bolumler VALUES(80, 'ARGE', 'ISTANBUL')");

//		// ORNEK 2: Bolumler tablosuna birden fazla yeni kayıt ekleyelim.
//		String[] sorgular = { "INSERT INTO bolumler VALUES(95, 'YEMEKHANE', 'ISTANBUL')",
//				              "INSERT INTO bolumler VALUES(85, 'OFIS','ANKARA')",
//				              "INSERT INTO bolumler VALUES(75, 'OFIS2', 'VAN')" };
//		
//		for (String w : sorgular) {
//			st.executeUpdate(w);
//		}
		
		// 2.YONTEM (addBath ve excuteBatch() metotlari ile)
		// ----------------------------------------------------
		// addBatch metodu ile SQL ifadeleri gruplandirilabilir ve exucuteBatch()
		// metodu ile veritabanina bir kere gonderilebilir.
		// excuteBatch() metodu bir int [] dizi dondurur. Bu dizi her bir ifade sonucunda 
		// etkilenen satir sayisini gosterir. 
		
//		String [] sorgular1 = {"INSERT INTO bolumler VALUES(81, 'YEMEKHANE2', 'MUS')",
//                "INSERT INTO bolumler VALUES(82, 'OFIS3','ORDU')",
//                "INSERT INTO bolumler VALUES(83, 'OFIS4', 'MUGLA')"};
//		for (String w : sorgular1) {
//			st.addBatch(w);
//		}
//		
//		st.executeBatch();
		
		   // 3. YONTEM
	       //-----------------------------------------------------
	       // batch metoduyla birlikte PreparedStatement kullanmak en efektif yontemdir.
	       // bir sonraki ornekte bunu gerceklestirecegiz.
		
		con.close();
		st.close();
		rs.close();

	}

}
