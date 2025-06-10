package com.artemiystark.sisyphean_reward

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.artemiystark.sisyphean_reward.R.string
import com.artemiystark.sisyphean_reward.navigation.SRNavigation
import com.artemiystark.sisyphean_reward.ui.theme.Sisyphean_RewardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Sisyphean_RewardTheme {

                Surface (
                    modifier = Modifier.fillMaxSize(),
                ) {
                    SRApp()
                }
            }

        }
    }
}


@Composable
fun SRApp() {
    SRNavigation()
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SRTopAppBar(
    title: String,
    canNavigateBack: Boolean,
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    navigateUp: () -> Unit = {}
) {
    CenterAlignedTopAppBar(
        title = { Text(title) },
        modifier = modifier,
        scrollBehavior = scrollBehavior,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Filled.ArrowBack,
                        contentDescription = stringResource(string.back_button)
                    )
                }
            }
        }
    )
}


@Composable
fun SRBottomAppBar (){
    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.primary,
    ) {
        Row() {
            Button(
                onClick = { /*GO BACK */},
                //modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.small,
                enabled = true
            ) {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = stringResource(R.string.home),
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = { /*GO HOME */},
                //modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.small,
                enabled = true
            ) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = stringResource(R.string.home),
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = { /* SETTINGS */},
                //modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.small,
                enabled = true
            ) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = stringResource(R.string.settings),
                )
            }
        }
    }
}