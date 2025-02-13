package io.github.guimatech.keycloak_with_openid_connect.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;


@Controller
public class HomeController {
  @GetMapping("/")
  public String home(Model model, @AuthenticationPrincipal OidcUser principal) {
      if (principal != null) {
          model.addAttribute("name", principal.getFullName());
          model.addAttribute("email", principal.getEmail());
      }
      return "home";
  }
  
}