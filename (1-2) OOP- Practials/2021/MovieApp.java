class Movie{
	private String title;
	private int year;
	private double budjet;
	private double worldwideEarnings;
	private String leadActor;
	private String productionCompany;
	 
	Movie(String title,int year,double budjet,double worldwideEarnings,String leadActor,String productionCompany){
		this.title=title;
		this.year=year;
		this.budjet=budjet;
		this.worldwideEarnings=worldwideEarnings;
		this.leadActor=leadActor;
		this.productionCompany=productionCompany;
	}
	
	String getTitle(){return title;}
	
	int getYear(){return year;}
	
	double getBudjet(){return budjet;}
	
	double getWorldwideEarnings(){return worldwideEarnings;}
	
	String getLeadActor(){return leadActor;}
	
	String getProductionCompany(){return productionCompany;}
	
	void play(){
		System.out.println("--Details of the movie--");
		System.out.println();
	}
}

class Actor{
	private String name;
	private String gender;
	private int age;
	private String country;
	
	Actor(String name,String gender,int age,String country){
		this.name=name;
		this.gender=gender;
		this.age=age;
		this.country=country;
	}
	
	String getName(){return name;}
	
	String getGender(){return gender;}
	
	int getAge(){return age;}
	
	String getCountry(){return country;}
	
	void displayInfo(){
		System.out.println("--Details of the actor--");
		System.out.println();
	}
	
}

class MovieApp{
	
	public static void main(String [] args){
		
		Actor a1=new Actor("","Male",47,"United");
		Actor a2=new Actor("","Male",60,"United");
		Actor a3=new Actor("","Male",47,"United");
		Actor a4=new Actor("","Male",59,"United");
		Actor a5=new Actor("","Male",37,"United");
		Actor a6=new Actor("","Male",38,"United");
		
		//Movie m1=new Movie();
		//m1.play();
	}

	
}

