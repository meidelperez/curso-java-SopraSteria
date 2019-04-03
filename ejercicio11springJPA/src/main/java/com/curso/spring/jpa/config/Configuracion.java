package com.curso.spring.jpa.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.curso.java.spring.jpa.model" })
@EnableTransactionManagement
public class Configuracion {

	/****
	 * con el data source me permite tener conexiones de forma eficiente no cierra
	 * conexiones, las devuelve a su almacen(pool) guarda una cache de sentencias
	 * precompiladas (LRU normalmente. Last Recently Used.) Evita asfixiar la base
	 * de datios ya que pone limite al numero de conexiones Esta mal hacerlo desde
	 * la app pero peor seria conectar con Conectioncon = new Conection();
	 */
	@Bean
	public DataSource dataSource() {
		// Clase para realizar las conexiones
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		// la cadena de conexion es distinta para cada base de datos
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		StringBuilder constructorDeCadenas = new StringBuilder("jdbc:mysql://localhost:3306/test");
		constructorDeCadenas.append("?useUnicode=true");
		constructorDeCadenas.append("&useJDBCCompilatTimezoneShift=true");
		constructorDeCadenas.append("&useLegacyDatetimeCode=false");
		constructorDeCadenas.append("&serverTimezone=UTC");
		dataSource.setUrl(constructorDeCadenas.toString());
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}

	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, Environment env) {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(dataSource);
		// implementacion que gestionara la base de datos , la que genera las sentencias
		factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		// donde se encencuentran los objetos que hay que persisrir
		factoryBean.setPackagesToScan("com.curso.java.spring.jpa.model.entities");
		Properties jpaProperties = new Properties();
		// Dialectoa utilizar dependiente de la base de datos y su version
		jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL55Dialect");
		// DDl data definition Language Constuccion de tablas

		jpaProperties.put("hibernate.hbm2ddl.auto", "update");// create-drop validate

		jpaProperties.put("hibernate.show.sql", "true");
		jpaProperties.put("hibernate.format.sql", "false");
		factoryBean.setJpaProperties(jpaProperties);
		return factoryBean;

	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory factory) {
		JpaTransactionManager manager = new JpaTransactionManager();
		manager.setEntityManagerFactory(factory);
		return manager;

	}

}
