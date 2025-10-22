# PowerShell script to set Java 21 as default
# Run this script as Administrator to set system-wide environment variables

Write-Host "Setting Java 21 as the default Java version..." -ForegroundColor Green

# Set JAVA_HOME to Java 21
$java21Path = "C:\Program Files\Microsoft\jdk-21.0.8.9-hotspot"

# Set for current user
[Environment]::SetEnvironmentVariable("JAVA_HOME", $java21Path, [EnvironmentVariableTarget]::User)
Write-Host "JAVA_HOME set to: $java21Path" -ForegroundColor Yellow

# Update PATH for current user
$currentPath = [Environment]::GetEnvironmentVariable("PATH", [EnvironmentVariableTarget]::User)
$newJavaPath = "$java21Path\bin"

# Remove any existing Java paths and add the new one at the beginning
$pathParts = $currentPath -split ';' | Where-Object { $_ -notlike "*jdk*\bin" -and $_ -ne "" }
$newPath = @($newJavaPath) + $pathParts -join ';'

[Environment]::SetEnvironmentVariable("PATH", $newPath, [EnvironmentVariableTarget]::User)
Write-Host "PATH updated to include Java 21 bin directory" -ForegroundColor Yellow

Write-Host "`nEnvironment variables updated successfully!" -ForegroundColor Green
Write-Host "Please restart your terminal/IDE to use the new Java version." -ForegroundColor Cyan

# Verify current Java version
Write-Host "`nCurrent Java version in this session:" -ForegroundColor Magenta
java -version