package techproeducation.JdbcExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc1Query01 {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// ilgili driver i yukle
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//baglanti olustur
		Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","hr","hr");  
		
		//sql komutlari icin bir statement nesnesi olustur 
		Statement st=con.createStatement();
		
		//sql ifadelerini yaz(personel tablosundaki personel id si 7369 olan personelin bilgilerini yazdir
		ResultSet isim = st.executeQuery("SELECT personel_isim, maas FROM personel WHERE personel_id=7369");
		
		//sonuclari aldik ve isledik
		while (isim.next()) {
			System.out.println(isim.getString("personel_isim")+isim.getInt("maas"));
		}
		
		//olusturulan nesneleri bellekten kaldiralim
        con.close();
        st.close();
        isim.close();
		
	}

}
