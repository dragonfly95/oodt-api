package com.example.stripedemo.controller;

import com.example.stripedemo.entity.Child;
import com.example.stripedemo.entity.Parent;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ParentVO {

	private long id;
	private String name;
	private ChildVO child;
	public ParentVO() {}
	
	public ParentVO(Parent p) {
		this.id = p.getId();
		this.name = p.getName();
		setChildVO(p.getChild());
		
	}

	private void setChildVO(Child child2) {
		this.child = new ChildVO(
		child2.getId(),
		child2.getName());
		
	}
}

@Getter
@ToString
class ChildVO {
	private long id;
	private String name;

	public ChildVO() {}
	public ChildVO(long id, String name) {
		this.id = id;
		this.name = name;
	}
}