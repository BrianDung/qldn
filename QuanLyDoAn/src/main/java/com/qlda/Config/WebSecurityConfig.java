package com.qlda.Config;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.qlda.Service.TaiKhoanService;


 
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
    @Autowired
    TaiKhoanService taiKhoanService;
 
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
 
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
 
        // Sét đặt dịch vụ để tìm kiếm User trong Database.
        // Và sét đặt PasswordEncoder.
        auth.userDetailsService(taiKhoanService).passwordEncoder(passwordEncoder());
 
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
 
        http.csrf().disable();
 
        // Các yêu cầu phải login với vai trò ROLE_EMPLOYEE hoặc ROLE_MANAGER.
        // Nếu chưa login, nó sẽ redirect tới trang /admin/login.
        http.authorizeRequests().antMatchers("/trangchu_quanly/sinhvien").hasRole("QuanLy");
   
        //  .access("hasRole('QuanLy')")
        //Chưa lấy được role
        
        // Các trang chỉ dành cho MANAGER
        //http.authorizeRequests().antMatchers("/admin/product").access("hasRole('ROLE_MANAGER')");
 
        // Khi người dùng đã login, với vai trò XX.
        // Nhưng truy cập vào trang yêu cầu vai trò YY,
        // Ngoại lệ AccessDeniedException sẽ ném ra.
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
 
        // Cấu hình cho Login Form.
        http.authorizeRequests().and().formLogin()//
  
                .loginPage("/login")//
                .defaultSuccessUrl("/formtaikhoan")//
                .usernameParameter("username")//
                .passwordParameter("password")
                .failureUrl("/login?error=true")//
 
                // Cấu hình cho trang Logout.
                // (Sau khi logout, chuyển tới trang home)
                .and().logout().logoutUrl("/admin/logout").logoutSuccessUrl("/trangchu_quanly/sinhvien");
 
    }
}