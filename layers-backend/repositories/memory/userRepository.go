package memory

import (
	"errors"
	"layersapi/data"
	"layersapi/entities"
)

type UserRepository struct{}

func (u UserRepository) GetAll() ([]entities.User, error) {
	return data.Data, nil
}

func (u UserRepository) GetById(id string) (entities.User, error) {
	for _, v := range data.Data {
		if v.Id() == id {
			return v, nil
		}
	}

	return entities.User{}, errors.New("user not found")
}

func (u UserRepository) Create(user entities.User) error {
	data.Data = append(data.Data, user)
	return nil
}

func (u UserRepository) Update(id string, user entities.User) error {
	for i, v := range data.Data {
		if v.Id() == id {
			data.Data[i].SetName(user.Name())
			data.Data[i].SetEmail(user.Email())
			return nil
		}
	}

	return errors.New("user not found")
}
