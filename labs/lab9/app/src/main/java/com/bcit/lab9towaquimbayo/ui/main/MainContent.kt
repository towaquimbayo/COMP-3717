package com.bcit.lab9towaquimbayo.ui.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bcit.lab9towaquimbayo.data.LocalUser

@Composable
fun MainContent(userState: UserState) {
    val signUpState = remember { SignUpState() }
    val users = remember { userState.users.toMutableStateList() }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        SignUpForm(signUpState)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 40.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CustomButton(text = "Add") {
                if (signUpState.uid.isNotEmpty()) {
                    if (users.contains(users.find { it.uid == signUpState.uid.toInt() })) {
                        users[users.indexOfFirst { it.uid == signUpState.uid.toInt() }] =
                            LocalUser(
                                uid = signUpState.uid.toInt(),
                                name = signUpState.name,
                                email = signUpState.email
                            )
                        userState.replace(
                            LocalUser(
                                uid = signUpState.uid.toInt(),
                                name = signUpState.name,
                                email = signUpState.email
                            )
                        )
                    } else {
                        userState.insertEntity(
                            LocalUser(
                                uid = signUpState.uid.toInt(),
                                name = signUpState.name,
                                email = signUpState.email
                            )
                        )
                        users.add(
                            LocalUser(
                                uid = signUpState.uid.toInt(),
                                name = signUpState.name,
                                email = signUpState.email
                            )
                        )
                    }
                } else {
                    userState.insertEntity(
                        LocalUser(
                            name = signUpState.name,
                            email = signUpState.email
                        )
                    )
                    users.add(
                        LocalUser(
                            name = signUpState.name,
                            email = signUpState.email
                        )
                    )
                }
            }
            CustomButton(text = "Refresh") { userState.refresh() }
        }
        LazyColumn(content = {
            items(users.size) {
                UserItem(users[it], signUpState, userState, users)
            }
        })
    }
}

@Composable
fun CustomButton(text: String, onClick: () -> Unit) {
    Button({ onClick() }) {
        Text(text = text, fontSize = 30.sp)
    }
}

@Composable
fun SignUpForm(signUpState: SignUpState) {
    CustomTextField(signUpState.uid, signUpState.onUidChanged, "uid")
    CustomTextField(signUpState.name, signUpState.onNameChanged, "name")
    CustomTextField(signUpState.email, signUpState.onEmailChanged, "email")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(value: String, onValueChange: (String) -> Unit, label: String) {
    Text(text = "$label:", fontSize = 14.sp, modifier = Modifier.padding(vertical = 2.dp))
    TextField(
        value = value,
        onValueChange = { onValueChange(it) },
        modifier = Modifier.fillMaxWidth(),
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserItem(
    user: LocalUser,
    signUpState: SignUpState,
    userState: UserState,
    users: MutableList<LocalUser>
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 7.dp),
        onClick = {
            signUpState.onUidChanged(user.uid.toString())
            signUpState.onNameChanged(user.name)
            signUpState.onEmailChanged(user.email)
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = user.name, fontSize = 20.sp)
            Text(text = user.email, fontSize = 20.sp)
            IconButton(onClick = {
                users.remove(user)
                userState.delete(user)
            }) {
                Icon(Icons.Default.Close, contentDescription = null)
            }
        }
    }
}