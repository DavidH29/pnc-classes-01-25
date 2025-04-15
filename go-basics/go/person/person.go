package person

type Individual struct{
	name string
	age int
}

func NewPerson(name string, age int) Individual {
	return Individual{name: name, age: age}
}

func (i *Individual) SetName(name string){
	i.name = name
}

func (i Individual) GetName() string {
	return i.name
}