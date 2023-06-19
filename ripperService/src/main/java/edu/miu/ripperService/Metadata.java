package edu.miu.ripperService;

public class Metadata {
	  private float generated;
	  private String url;
	  private String title;
	  private float status;
	  private String api;
	  private float limit;
	  private float offset;
	  private float count;


	 // Getter Methods 

	  public float getGenerated() {
	    return generated;
	  }

	  public String getUrl() {
	    return url;
	  }

	  public String getTitle() {
	    return title;
	  }

	  public float getStatus() {
	    return status;
	  }

	  public String getApi() {
	    return api;
	  }

	  public float getLimit() {
	    return limit;
	  }

	  public float getOffset() {
	    return offset;
	  }

	  public float getCount() {
	    return count;
	  }

	 // Setter Methods 

	  public void setGenerated( float generated ) {
	    this.generated = generated;
	  }

	  public void setUrl( String url ) {
	    this.url = url;
	  }

	  public void setTitle( String title ) {
	    this.title = title;
	  }

	  public void setStatus( float status ) {
	    this.status = status;
	  }

	  public void setApi( String api ) {
	    this.api = api;
	  }

	  public void setLimit( float limit ) {
	    this.limit = limit;
	  }

	  public void setOffset( float offset ) {
	    this.offset = offset;
	  }

	  public void setCount( float count ) {
	    this.count = count;
	  }

	@Override
	public String toString() {
		return "Metadata [generated=" + generated + ", url=" + url + ", title=" + title + ", status=" + status
				+ ", api=" + api + ", limit=" + limit + ", offset=" + offset + ", count=" + count + "]";
	}
	}
