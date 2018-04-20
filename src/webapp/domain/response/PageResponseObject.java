package webapp.domain.response;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import io.swagger.annotations.ApiModelProperty;

@RefreshScope
public class PageResponseObject extends ResponseObject{
	@Value("${referenceData.page.size}")
	private int PAGE_SIZE;
	private Long totalCount;
	private Integer totalPageCount;
	private Integer pageSize;
	private Integer currentPage;
	public PageResponseObject(String errorMsg){
		super(errorMsg);
	}
	public PageResponseObject(Integer count, List<? extends Object> objList, Long totalCount, Integer totalPageCount,
			Integer pageSize, Integer currentPage) {
		super(count, objList);
		this.totalCount = totalCount;
		this.totalPageCount = totalPageCount;
		this.pageSize = pageSize;
		this.currentPage = currentPage;
	}

	@ApiModelProperty(notes = "Total count of data for the passed parameters", required = false)
	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	@ApiModelProperty(notes = "Total count of pages for the passed parameters", required = false)
	public Integer getTotalPageCount() {
		return totalPageCount;
	}

	
	public void setTotalPageCount(Integer totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	@ApiModelProperty(notes = "Page size specified, defaults to 5000", required = false)
	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	@ApiModelProperty(notes = "Current page number for the passed parameters ", required = false)
	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

}