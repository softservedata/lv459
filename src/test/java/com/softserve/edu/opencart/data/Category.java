package com.softserve.edu.opencart.data;

interface ICategoryName {
	ICategoryTitle setName(String name);
}

interface ICategoryTitle {
	IParent setTitle(String title);
}

interface IParent {
	IBuildCategory setParent(String parent);
}

interface IBuildCategory {
	ICategory build();
}

public final class Category
		implements ICategoryName, ICategoryTitle, IParent, IBuildCategory, ICategory {
	String name;
	String title;
	String parent;

    public static ICategoryName get() {
        return new Category();
    }

		public ICategoryTitle setName(String name) {
			this.name = name;
			return this;
		}

		public String getName() {
			return name;
		}

		public IParent setTitle(String title) {
			this.title = title;
			return this;
		}
		
		public String getTitle() {
			return title;
		}

		public IBuildCategory setParent(String parent) {
			this.parent = parent;
			return this;
		}
		
		public String getParent() {
			return parent;
		}

		public ICategory build() {
			return this;
		}

}