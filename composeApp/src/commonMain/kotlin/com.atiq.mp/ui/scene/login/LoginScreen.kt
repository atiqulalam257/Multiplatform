package com.atiq.mp.ui.scene.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.atiq.mp.data.account.LoginState
import com.atiq.mp.ui.components.TextInputItem
import com.atiq.mp.ui.components.TextItem
import com.atiq.mp.utils.Constants
import multiplateform.composeapp.generated.resources.Res
import multiplateform.composeapp.generated.resources.ic_login_movee
import multiplateform.composeapp.generated.resources.login_background
import multiplateform.composeapp.generated.resources.login_forgot_password
import multiplateform.composeapp.generated.resources.login_password
import multiplateform.composeapp.generated.resources.login_register
import multiplateform.composeapp.generated.resources.login_title
import multiplateform.composeapp.generated.resources.login_username
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun LoginScreen(
    viewModel: LoginViewModel,
    navigateToWebViewScreen: (String) -> Unit,
    navigateToMainScreen: () -> Unit,
) {
    val isLoggedState by viewModel.isLoggedIn.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(Res.drawable.login_background),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier.fillMaxHeight(0.35f),
            ) {
                Image(
                    modifier = Modifier.align(Alignment.Center),
                    painter = painterResource(Res.drawable.ic_login_movee),
                    contentDescription = null
                )
            }

            LoginContent(
                loginUiState = viewModel.loginUiState,
                onUserNameChange = viewModel::onUserNameChange,
                onPasswordChange = viewModel::onPasswordChange,
                onLogin = viewModel::login,
                isLoggedIn = isLoggedState,
                navigateToWebViewScreen = navigateToWebViewScreen,
                navigateToMainScreen = navigateToMainScreen,
            )
        }
    }
}

@Composable
fun LoginContent(
    loginUiState: LoginUiState,
    onUserNameChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLogin: () -> Unit,
    isLoggedIn: LoginState,
    navigateToWebViewScreen: (String) -> Unit,
    navigateToMainScreen: () -> Unit,
) {
    Box(modifier = Modifier.fillMaxSize()){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (loginUiState.loginError != null) {
                Text(text = loginUiState.loginError, color = Color.White)
            }

            TextInputItem(
                modifier = Modifier.fillMaxWidth(),
                query = loginUiState.userName,
                onValueChange = { onUserNameChange(it) },
                label = {
                    TextItem(
                        text = stringResource(Res.string.login_username),
                        textColor = MaterialTheme.colorScheme.primaryContainer
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        tint = Color.White,
                        contentDescription = stringResource(Res.string.login_username)
                    )
                },
                isError = loginUiState.loginError != null
            )

            TextInputItem(
                modifier = Modifier.fillMaxWidth(),
                query = loginUiState.password,
                onValueChange = { onPasswordChange(it) },
                label = {
                    TextItem(
                        text = stringResource(Res.string.login_password),
                        textColor = MaterialTheme.colorScheme.primaryContainer
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        tint = Color.White,
                        contentDescription = stringResource(Res.string.login_password)
                    )
                },
                isError = loginUiState.loginError != null,
                visualTransformation = PasswordVisualTransformation()
            )

            Row {
                TextItem(
                    text = stringResource(Res.string.login_forgot_password),
                    modifier = Modifier.clickable {
                        navigateToWebViewScreen(Constants.FORGOT_PASSWORD)
                    },
                    textColor = MaterialTheme.colorScheme.primaryContainer
                )
            }

            Button(
                modifier = Modifier.fillMaxWidth().padding(32.dp),
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Blue
                ),
                onClick = { onLogin() }) {
                TextItem(
                    text = stringResource(Res.string.login_title),
                    textColor = MaterialTheme.colorScheme.primary
                )
            }

            TextItem(
                text = stringResource(Res.string.login_register),
                modifier = Modifier.clickable {
                    navigateToWebViewScreen(Constants.REGISTER)
                },
                textColor = MaterialTheme.colorScheme.primaryContainer
            )

            LaunchedEffect(key1 = isLoggedIn) {
                if (isLoggedIn == LoginState.LOGGED_IN) {
                    navigateToMainScreen()
                }
            }
        }

        if (loginUiState.isLoading){
            CircularProgressIndicator()
        }
    }
}
