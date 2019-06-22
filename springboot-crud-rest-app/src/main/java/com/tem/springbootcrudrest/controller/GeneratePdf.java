package com.tem.springbootcrudrest.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.DocumentException;

@RestController
@RequestMapping("/export")
//@RequestMapping(value = "generatePDF.htm", method = RequestMethod.GET)
public class GeneratePdf {
	@GetMapping("/generatePDF")
	  public void exportToPDF(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
	    
	   
	  }
}
