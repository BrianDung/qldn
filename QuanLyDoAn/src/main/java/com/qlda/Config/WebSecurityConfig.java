package com.qlda.Config;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.qlda.Service.TaiKhoanService;


 
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
    @Autowired
    TaiKhoanService taiKhoanService;
 
    @Bean("authenticationManager")
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
    }
    
    @Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
        return new MySimpleUrlAuthenticationSuccessHandler();
    }
    
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
        http.authorizeRequests().antMatchers("/trangchu_quanly/**").hasRole("QUAN_LY")
        .antMatchers("/trangchu_giangvien/**").hasRole("GIANG_VIEN")
        .antMatchers("/trangchu_sinhvien/**").hasRole("SINH_VIEN");
        
   
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
                //.defaultSuccessUrl("/formtaikhoan")//
                .successHandler(myAuthenticationSuccessHandler())
                .usernameParameter("username")//
                .passwordParameter("password")
                .failureUrl("/login?error=true")//
 
                // Cấu hình cho trang Logout.
                // (Sau khi logout, chuyển tới trang home)
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login");
 
    }
}