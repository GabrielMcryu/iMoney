package com.gabriel.imoney.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReferenceData {

	@JsonProperty("ReferenceItem")
	private ReferenceItem referenceItem;

	public ReferenceItem getReferenceItem() {
		return referenceItem;
	}

	public void setReferenceItem(ReferenceItem referenceItem) {
		this.referenceItem = referenceItem;
	}

	public ReferenceData() {

	}

	public ReferenceData(ReferenceItem referenceItem) {
		this.referenceItem = referenceItem;
	}

	@Override
	public String toString() {
		return "ReferenceData [referenceItem=" + referenceItem + "]";
	}
	
	
}
