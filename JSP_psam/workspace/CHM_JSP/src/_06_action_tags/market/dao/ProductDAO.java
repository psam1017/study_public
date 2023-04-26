package _06_action_tags.market.dao;

import java.util.ArrayList;

import _06_action_tags.market.dto.ProductDTO;

public class ProductDAO {
	
	private ArrayList<ProductDTO> listOfProducts = new ArrayList<>();
	private static ProductDAO instance = new ProductDAO();
	
	public static ProductDAO getInstance() {
		return instance;
	}
	public ProductDAO() {
		
		ProductDTO phone = new ProductDTO("p1000", "아이폰 6", 80000);
		phone.setDescription("엄청 비쌈");
		phone.setCategory("스마트폰");
		phone.setManufacturer("애플");
		phone.setUnitsInStock(1000);
		phone.setCondition("Old");
		phone.setFilename("p1000.png");
		
		ProductDTO laptop = new ProductDTO("p2000", "LG 그램", 200000);
		laptop.setDescription("가벼움");
		laptop.setCategory("노트북");
		laptop.setManufacturer("엘지");
		laptop.setUnitsInStock(1000);
		laptop.setCondition("Refurbished");
		laptop.setFilename("p2000.png");
		
		ProductDTO tablet = new ProductDTO("p3000", "갤럭시 탭", 150000);
		tablet.setDescription("아이패드보다 안 좋음");
		tablet.setCategory("태블릿");
		tablet.setManufacturer("삼성");
		tablet.setUnitsInStock(1000);
		tablet.setCondition("New");
		tablet.setFilename("p3000.png");
		
		listOfProducts.add(phone);
		listOfProducts.add(laptop);
		listOfProducts.add(tablet);
	}
	
	public ArrayList<ProductDTO> getAllProducts(){
		return listOfProducts;
	}
	
	public ProductDTO getProductById(String productId) {
		
		ProductDTO productById = null;
		
		for(ProductDTO p : listOfProducts) {
			ProductDTO product = p;
			if(product != null && product.getProductID() != null && product.getProductID().equals(productId)) {
				productById = product;
				break;
			}
		}
		return productById;
	}
	
	public void addProduct(ProductDTO productDTO) {
		listOfProducts.add(productDTO);
	}
}
