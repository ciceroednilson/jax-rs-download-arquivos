package br.com.ciceroednilson.app;

import java.io.File;
import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/service")
public class Service {

	/**Declarando um objeto File para pegar o arquivo que vai ser feito o Download*/
	private File file;
		
	
	/**Declarando um objeto ResponseBuilder para gerar a resposta com os nossos arquivos 
	 * para download*/
	private ResponseBuilder  responseBuilder;
		
	
	/**Monta o caminho dos arquivos onde vamos realizar o download,
	 * no meu caso coloquei em uma pasta que está no mesmo nível da pasta que contem a minha
	 * aplicação 
	 *
	 *Arquivos: /home/cicero/arquivos
	 *Aplicação:/home/cicero/workspace
	 * 
	 * */
	private String caminhoPasta;	
	
	
	/**Construtor**/
	public Service(){
		
		try {
			
			//Pegando o caminho raiz
			caminhoPasta = new File(".").getCanonicalPath();
			
			//concatenando o caminho raiz com o nome da pasta onde estão nossos arquivos
			caminhoPasta = caminhoPasta.concat("/").concat("arquivos");
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}
	
	/**
	 * DOWNLOAD DE ARQUIVO TXT
	 * 
	 *@GET  = Método HTTP
	 *@Path = Caminho para acessar o método via http
	 *@Produces("text/plain") = Determinamos o media types que vamos usar para receber a resposta 
	 * */
	@GET
	@Path("/gettxt") 
	@Produces("text/plain")
	public Response getTxt(){
		
		//pegando o arquivo texto para download
		file = new File(caminhoPasta + "/cicero.txt");
		
		/*Criando um novo ResponseBuilder e adicionando o arquivo
		que vai ser disponibilizado para download*/
		responseBuilder = Response.ok(file);
		
		//informando o cabeçalho
		responseBuilder.header("Content-Disposition", "attachment;filename=" + file.getName());
		
		//Retornando a nossa resposta para a realização do download
		return responseBuilder.build();
		
	}
	
	/**
	 * 
	 * 	 * DOWNLOAD DE IMAGEM
	 * */
	@GET
	@Path("/getimagem")
	@Produces("image/png")
	public Response getImagem(){
		
		file = new File(caminhoPasta + "/imagem.png");
		
		responseBuilder = Response.ok(file);
		
		responseBuilder.header("Content-Disposition", "attachment;filename=" + file.getName());
		
		return responseBuilder.build();
		
	}
	
	/**
	 * 
	 * 	 * DOWNLOAD DE ARQUIVO PDF
	 * */
	@GET
	@Path("/getpdf")
	@Produces("application/pdf")
	public Response getPdf(){
		
		file = new File(caminhoPasta + "/Java.pdf");
		
		responseBuilder = Response.ok(file);
		
		responseBuilder.header("Content-Disposition", "attachment;filename=" + file.getName());
		
		return responseBuilder.build();
		
	}
	
	/**
	 * 
	 * DOWNLOAD DE ARQUIVO EXCEL
	 * */	
	@GET
	@Path("/getexcel")
	@Produces("application/vnd.ms-excel")
	public Response getExcel(){
		
		file = new File(caminhoPasta + "/planilha.xlsx");
		
		responseBuilder = Response.ok(file);
		
		responseBuilder.header("Content-Disposition", "attachment;filename=" + file.getName());
		
		return responseBuilder.build();
		
	}
	
	/**
	 * 
	 * DOWNLOAD DE ARQUIVO ZIP
	 * */
	@GET
	@Path("/getzip")
	@Produces("application/zip")
	public Response getZip(){
		
		file = new File(caminhoPasta + "/tudo.zip");
		
		responseBuilder = Response.ok(file);
		
		responseBuilder.header("Content-Disposition", "attachment;filename=" + file.getName());
		
		return responseBuilder.build();
		
	}
	
	
	
}
