package entities

type User struct {
	id    string
	name  string
	email string
	Metadata
}

func NewUser(id string, name string, email string, metadata Metadata) User {
	return User{
		id:       id,
		name:     name,
		email:    email,
		Metadata: metadata,
	}
}

/* This, although works, is bad practice

type User struct {
	id            string
	name          string
	email         string
	CreatedAt     time.Time
	CreatedBy     string
	LastUpdatedAt time.Time
	LastUpdatedBy string
}

func NewUser(id string, name string, email string, createdAt time.Time, createdBy string, lastUpdatedAt time.Time, lastUpdatedBy string) *User {
	return &User{id: id, name: name, email: email, createdAt: createdAt, createdBy: createdBy, lastUpdatedAt: lastUpdatedAt, lastUpdatedBy: lastUpdatedBy}
}*/

// Getters
func (u *User) Id() string    { return u.id }
func (u *User) Name() string  { return u.name }
func (u *User) Email() string { return u.email }

// Setters
func (u *User) SetName(name string) {
	//if len(name) == 0 {
	//	return errors.New("name cannot be empty")
	//}
	//
	//re, _ := regexp.Compile(`^[A-Za-z]+$`)
	//if !re.MatchString(name) {
	//	return errors.New("name must only contain alphabetic characters")
	//}

	u.name = name
}

func (u *User) SetEmail(email string) {
	//re, _ := regexp.Compile(`^[a-zA-Z0-9._%+\-]+@[a-zA-Z0-9.\-]+\.[a-zA-Z]{2,}$`)
	//
	//if !re.MatchString(email) {
	//	return errors.New("invalid email address")
	//}

	u.email = email
}
