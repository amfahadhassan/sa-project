package edu.miu.ripperService;

import java.util.ArrayList;

public class NewEarthquakeData {
	  private String type;
	  Metadata MetadataObject;
	  ArrayList<Object> features = new ArrayList<Object>();


	 // Getter Methods 

	  public String getType() {
	    return type;
	  }

	  public Metadata getMetadata() {
	    return MetadataObject;
	  }

	 // Setter Methods 

	  public void setType( String type ) {
	    this.type = type;
	  }

	  public void setMetadata( Metadata metadataObject ) {
	    this.MetadataObject = metadataObject;
	  }

	@Override
	public String toString() {
		return "NewEarthquakeData [type=" + type + ", MetadataObject=" + MetadataObject + ", features=" + features
				+ "]";
	}
	}
	